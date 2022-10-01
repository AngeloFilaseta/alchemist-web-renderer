import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import it.unibo.alchemist.AlchemistExecutionOptions
import it.unibo.alchemist.launch.ServerLauncher
import it.unibo.alchemist.launch.Validation

class ServerLauncherTest : StringSpec(
    {

        val expectedLauncherName = "REST Server Launcher"

        fun checkOptionsAreInvalid(options: AlchemistExecutionOptions, reason: String) {
            ServerLauncher.validate(options) shouldBe Validation.Invalid(reason)
        }

        fun checkOptionsAreValid(options: AlchemistExecutionOptions) {
            ServerLauncher.validate(options) shouldBe Validation.OK()
        }

        "ServerLauncher should have the correct name" {
            ServerLauncher.name shouldBe expectedLauncherName
        }

        "AlchemistExecutionOptions should not contain distributed" {
            checkOptionsAreInvalid(
                AlchemistExecutionOptions(configuration = "placeholder", distributed = "something"),
                "$expectedLauncherName is not compatible with distributed execution"
            )
        }

        "AlchemistExecutionOptions should not contain graphics" {
            checkOptionsAreInvalid(
                AlchemistExecutionOptions(configuration = "placeholder", graphics = "something"),
                "$expectedLauncherName is not compatible with graphics"
            )
        }

        "AlchemistExecutionOptions can contain only headless" {
            checkOptionsAreInvalid(
                AlchemistExecutionOptions(
                    configuration = "placeholder",
                    headless = true,
                    distributed = "something",
                    graphics = "something"
                ),
                "$expectedLauncherName is not compatible with distributed execution"
            )
        }

        "AlchemistExecutionOptions can contain headless" {
            checkOptionsAreValid(AlchemistExecutionOptions(configuration = "placeholder", headless = true))
        }

        "AlchemistExecutionOptions can contain only configuration" {
            checkOptionsAreValid(AlchemistExecutionOptions(configuration = "placeholder"))
        }
    }
)
