sealed abstract class Tree
case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree


object TestTree {

  def depth(tree: Tree): Int = {
    tree match {
      case Empty => 0
      case Branch(_, lt, rt) =>
        val dlt = depth(lt)
        val drt = depth(rt)
        1 + (if (dlt >= drt) dlt else drt)
    }
  }

  def main0(args: Array[String]): Unit = {
    println(
      depth(Empty) == 0
    )
    println(
      depth(Branch(10, Empty, Empty)) == 1
    )
    println(
      depth(Branch(10, Branch(20,
                          Empty,
                          Empty
                       ), Empty)) == 2
    )
    // 右のBranchの方が、左のBranchよりも深い
    println(
      depth(Branch(10, Branch(20,
                          Empty,
                          Empty
                       ), Branch(30,
                          Branch(40,
                              Empty,
                              Empty
                          ),
                       Empty))) == 3
    )
  }
}
