package kotfx.dialogs

interface InputDialogBuilder : DialogBuilder<String> {

    fun prefill(prefill: String)
}