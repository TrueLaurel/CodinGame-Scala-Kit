package com.truelaurel.codingame.metaheuristic.hillclimbing

import com.truelaurel.codingame.metaheuristic.model.{Problem, Solution}
import com.truelaurel.codingame.time.Chronometer

import scala.concurrent.duration.Duration

/**
  * Only better solution leads to new exploration
  */
class HillClimbing(duration: Duration) {

  val chrono = new Chronometer(duration)

  def search[S <: Solution](problem: Problem[S]): S = {
    var solution = problem.randomSolution()
    chrono.start()
    while (!problem.isGoodEnough(solution) && !chrono.isRunOut) {
      val tweaked = problem.tweakSolution(solution)
      solution = if (tweaked.quality() > solution.quality()) tweaked else solution
    }
    solution
  }

}
