package visual


interface VisualFunction {
    fun enter(functionName: String, notes: String = "")
    fun exit(notes: String = "")

    val traceCalls: MutableList<FunCall>

    // todo: refactor
    fun buildSequence(): String
    fun buildTextSequence(): String
}

data class FunCall(val functionName: String, val notes: String = "")

class BasicVisualFunction : VisualFunction {
    override val traceCalls = mutableListOf<FunCall>()

    override fun enter(functionName: String, notes: String) {
        traceCalls.add(FunCall(functionName, notes))
    }

    override fun exit(notes: String) {
        traceCalls.add(FunCall("EXIT", notes))
    }

    override fun buildSequence(): String {
        val callStack = mutableListOf<FunCall>()
        val result = mutableListOf<String>()

        for (call in traceCalls) {
            if (call.functionName.startsWith("EXIT")) {
                val prevCall = callStack[callStack.size - 1]
                result.add("${prevCall.functionName}-->-${callStack[callStack.size - 1].functionName}:${call.notes}")
                callStack.removeAt(callStack.size - 1)
                continue
            }
            val prevCall = if (callStack.isNotEmpty()) callStack[callStack.size - 1] else FunCall("INIT")
            result.add("${prevCall.functionName}->+${call.functionName}:${call.notes}")
            callStack.add(call)
        }
        return result.joinToString("\n")
    }

    override fun buildTextSequence(): String {
        val callStack = mutableListOf<FunCall>()
        val result = mutableListOf<String>()

        for (call in traceCalls) {
            if (call.functionName.startsWith("EXIT")) {
                callStack.removeAt(callStack.size - 1)
                continue
            }
            repeat(callStack.size) {
                print(".\t")
            }
            callStack.add(call)
            print("${call.functionName}: ${call.notes}\n")
        }
        val k = "blavla";

        return result.joinToString("\n")
    }
}
