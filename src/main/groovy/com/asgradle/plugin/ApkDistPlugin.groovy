package com.asgradle.plugin
import org.gradle.api.Project;
import org.gradle.api.Plugin;

class ApkDistPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.extensions.create('apkdistconf', ApkDistExtension);

        project.task('apkdist') {
            doLast{
                println 'hello, world!'

                def closure = project['apkdistconf'].nameMap;
                closure('wow!');

                println project['apkdistconf'].destDir
            }
        }

    }
}