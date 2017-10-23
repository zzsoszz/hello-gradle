package com.asgradle.plugin
import org.gradle.api.Project;
import org.gradle.api.Plugin
import org.gradle.api.tasks.SourceSet;

class ApkDistPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.extensions.create('apkdistconf', ApkDistExtension);

        project.task('apkdist') {
            doLast {
                println 'hello, world!'
                def closure = project['apkdistconf'].nameMap;
                closure('wow!');
                def sourceset=project['apkdistconf'].destDir as SourceSet;
                sourceset.getCompileClasspath().each {
                    println "ApkDistPlugin output:"+it.getAbsolutePath()
                }
            }
        }

    }
}