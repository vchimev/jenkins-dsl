package webpack.jobs

import javaposse.jobdsl.dsl.Job

public class Webpack {

    static def createJob(Job job)
    {
        DefaultJobTemplate.apply(job)
    }
}

public class DefaultJobTemplate {

    static def apply(Job job){

        // Apply general service test template
        job.with {

            // UI tests runner label is set
            label('master')

            // Apply general policy for keeping old test runs
            logRotator(Config.daysToKeepBuilds, -1, -1, -1)

            wrappers {
                colorizeOutput('xterm')
            }
        }
    }
}