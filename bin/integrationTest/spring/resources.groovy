import demoapp.UserPasswordEncoderListener
import demoapp.CustomUserDetailsService
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userDetailsService(CustomUserDetailsService)
    userDetailsPasswordService(CustomUserDetailsPasswordService)
}
