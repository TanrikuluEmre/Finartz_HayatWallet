import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.lifecycle.ViewModel

class WelcomeFragmentViewModel  : ViewModel() {

    fun bold(startBold: Int, endBold: Int, text: String, textView: TextView) {
        val spannable = SpannableString(text)
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            startBold,
            endBold,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable
    }


}
