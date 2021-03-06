package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.BuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        step {
            type = "Xcode"
            param("customBuildOutputDir", "ios/build")
            param("project", "ios/testapp.xcodeproj")
            param("runTests", "true")
            param("scheme", "testapp")
            param("useCustomBuildOutputDir", "true")
        }
    }
    steps {
        insert(0) {
            script {
                name = "node preinstall"
                scriptContent = "npm install"
                dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
            }
        }
        update<BuildStep>(1) {
        }
    }
}
