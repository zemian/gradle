/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.execution.impl.steps;

import org.gradle.internal.Try;
import org.gradle.internal.execution.ExecutionOutcome;
import org.gradle.internal.execution.OutputChangeListener;
import org.gradle.internal.execution.Result;
import org.gradle.internal.execution.UnitOfWork;

import java.util.Optional;

public class ExecuteStep implements Step<Context, Result> {

    private final OutputChangeListener outputChangeListener;

    public ExecuteStep(
        OutputChangeListener outputChangeListener
    ) {
        this.outputChangeListener = outputChangeListener;
    }

    @Override
    public Result execute(Context context) {
        UnitOfWork work = context.getWork();

        Optional<? extends Iterable<String>> changingOutputs = work.getChangingOutputs();
        changingOutputs.ifPresent(outputs -> outputChangeListener.beforeOutputChange(outputs));
        if (!changingOutputs.isPresent()) {
            outputChangeListener.beforeOutputChange();
        }
        ExecutionOutcome outcome = work.execute();
        return new Result() {
            @Override
            public Try<ExecutionOutcome> getOutcome() {
                return Try.successful(outcome);
            }
        };
    }
}
