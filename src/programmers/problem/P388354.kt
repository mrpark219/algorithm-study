package programmers.problem

class P388354 {

    private val nodeMap = mutableMapOf<Int, MutableList<Int>>()

    fun solution(nodes: IntArray, edges: Array<IntArray>): IntArray {

        for(node in nodes) {
            nodeMap[node] = mutableListOf()
        }

        // 간선 초기화
        for(edge in edges) {
            val a = edge[0]
            val b = edge[1]

            nodeMap[a]!!.add(b)
            nodeMap[b]!!.add(a)
        }

        var countTree = 0
        var countReverseTree = 0
        // 모든 노드마다 확인
        for(node in nodes) {

            val result = checkTree(node, -1, checkType(node, -1))

            if(result == 1) {
                countTree++
            }
            else if(result == 2) {
                countReverseTree++
            }
        }

        return intArrayOf(countTree, countReverseTree)
    }

    // 0이면 불가능, 1이면 홀짝트리, 2이면 역홀짝트리
    private fun checkTree(node: Int, parent: Int, type: Int): Int {
        // node의 자식 노드들에 대해 탐색
        for(child in nodeMap[node]!!) {

            if(child == parent) {
                continue
            }

            val childType = checkType(child, node)

            if(type != childType) {
                return 0
            }

            val result = checkTree(child, node, type)

            if(result == 0) {
                return 0
            }
        }

        return type
    }


    private fun checkType(node: Int, parent: Int): Int {

        var childrenSize = 0
        childrenSize = if(parent == -1) {
            nodeMap[node]!!.size
        }
        else {
            nodeMap[node]!!.size - 1
        }

        val nodeValue = node % 2 == 0
        val nodeChildren = childrenSize % 2 == 0

        return if(nodeValue == nodeChildren) 1 else 2
    }
}

fun main() {

    val nodes = intArrayOf(9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10)
    val edges = arrayOf(
        intArrayOf(5, 14),
        intArrayOf(1, 4),
        intArrayOf(9, 11),
        intArrayOf(2, 15),
        intArrayOf(2, 5),
        intArrayOf(9, 7),
        intArrayOf(8, 1),
        intArrayOf(6, 4)
    )

    println(P388354().solution(nodes, edges).contentToString())
}