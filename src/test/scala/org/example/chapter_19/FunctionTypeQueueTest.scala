package org.example.chapter_19

import org.scalatest.FunSuite

class FunctionTypeQueueTest extends FunSuite {

  // TODO: 時間計測クラスを実装する。
  
  test("FunctionTypeQueueTest.") {
    def create(elems: List[Int]): SlowAppendQueue[Int] = {
      elems.length match {
        case 100 => new SlowAppendQueue(elems)
        case _ => create(elems ::: elems.length + 1 :: Nil)
      }
    }
    val queue = create(Nil)
    printf("head=%d", queue.head)
  }
}
