/*
 * Copyright 2012 the original author or authors.
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

package org.gradle.api.internal.tasks.compile;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class DefaultJvmLanguageCompileSpec implements JvmLanguageCompileSpec, Serializable {
    private File workingDir;
    private File tempDir;
    private List<File> classpath;
    private File destinationDir;
    private Iterable<File> sourceFiles;
    private String sourceCompatibility;
    private String targetCompatibility;

    @Override
    public File getWorkingDir() {
        return workingDir;
    }

    @Override
    public void setWorkingDir(File workingDir) {
        this.workingDir = workingDir;
    }

    @Override
    public File getDestinationDir() {
        return destinationDir;
    }
    @Override
    public void setDestinationDir(File destinationDir) {
        this.destinationDir = destinationDir;
    }

    @Override
    public File getTempDir() {
        return tempDir;
    }

    @Override
    public void setTempDir(File tempDir) {
        this.tempDir = tempDir;
    }

    @Override
    public Iterable<File> getSourceFiles() {
        return sourceFiles;
    }

    @Override
    public void setSourceFiles(Iterable<File> sourceFiles) {
        this.sourceFiles = sourceFiles;
    }

    @Override
    public List<File> getCompileClasspath() {
        return classpath;
    }

    @Override
    public void setCompileClasspath(List<File> classpath) {
        this.classpath = classpath;
    }

    @Override
    public String getSourceCompatibility() {
        return sourceCompatibility;
    }

    @Override
    public void setSourceCompatibility(String sourceCompatibility) {
        this.sourceCompatibility = sourceCompatibility;
    }

    @Override
    public String getTargetCompatibility() {
        return targetCompatibility;
    }

    @Override
    public void setTargetCompatibility(String targetCompatibility) {
        this.targetCompatibility = targetCompatibility;
    }
}
