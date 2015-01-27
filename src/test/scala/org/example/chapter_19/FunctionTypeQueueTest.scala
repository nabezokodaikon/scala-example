package org.example.chapter_19

import org.scalatest.FunSuite
import com.twitter.util._

class FunctionTypeQueueTest extends FunSuite {

  // TODO: 時間計測クラスを実装する。

  test("FunctionTypeQueueTest.") {
    def create(elems: List[Int]): SlowAppendQueue[Int] = {
      elems.length match {
        case 100 => new SlowAppendQueue(elems)
        case _ => create(elems ::: elems.length + 1 :: Nil)
      }
    }

    val createSw = Stopwatch.start
    val queue = create(Nil)
    printf("create=%d\n", createSw().inMicroseconds)

    val headSw = Stopwatch.start
    queue.head
    printf("head=%d\n", headSw().inMicroseconds)
  }
}
