package proscalafx.ch02.metronometransition

import javafx.animation.Animation.Status
import scalafx.Includes.actionEventClosureWrapper
import scalafx.Includes.jfxDuration2sfx
import scalafx.animation.TranslateTransition.sfxTranslateTransition2jfx
import scalafx.animation.Interpolator
import scalafx.animation.Timeline
import scalafx.animation.TranslateTransition
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.control.Button
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.util.Duration

object MetronomeTransitionMain extends JFXApp {

  val circle = new Circle {
    centerX = 100
    centerY = 50
    radius = 4
    fill = Color.BLUE
  }

  val anim = new TranslateTransition {
    duration = Duration(1000.0)
    node = circle
    fromX = 0
    toX = 200
    interpolator = Interpolator.LINEAR
    autoReverse = true
    cycleCount = Timeline.INDEFINITE
  }

  stage = new Stage {
    width = 400
    height = 500
    title = "Metronome using TranslateTransition"
    scene = new Scene {
      content = List(
        circle,
        new HBox {
          layoutX = 60
          layoutY = 420
          spacing = 10
          content = List(
            new Button {
              text = "Start"
              onAction = (ae: ActionEvent) => anim.playFromStart
              disable <== anim.status.isNotEqualTo(Status.STOPPED)
            },
            new Button {
              text = "Pause"
              onAction = (ae: ActionEvent) => anim.pause
              disable <== anim.status.isNotEqualTo(Status.RUNNING)
            },
            new Button {
              text = "Resume"
              onAction = (ae: ActionEvent) => anim.play
              disable <== anim.status.isNotEqualTo(Status.PAUSED)
            },
            new Button {
              text = "Stop"
              onAction = (ae: ActionEvent) => anim.stop
              disable <== anim.status.isNotEqualTo(Status.STOPPED)
            })
        })
    }
  }

}