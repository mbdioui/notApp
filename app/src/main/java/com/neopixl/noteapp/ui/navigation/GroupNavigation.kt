import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neopixl.noteapp.ui.navigation.GroupDestination

@Composable
fun GroupNavigation(groupNavController: NavHostController) {
    NavHost(groupNavController, startDestination = GroupDestination.MainGroup.route) {
        composable(GroupDestination.MainGroup.route) {
            MainGroupScreen()
        }
    }
}

@Composable
fun MainGroupScreen() {
    Text("this is the main Group Screen")
}