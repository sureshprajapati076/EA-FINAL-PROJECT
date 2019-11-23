import React , {Component} from 'react'
class Signup extends Component{
    render(){
        return(
            <div class="tab-content" id="tab2" style="display: none;">

            <form method="post" class="register">
                
            <p class="form-row form-row-wide">
                <label for="username2">Username:
                    <i class="im im-icon-Male"></i>
                    <input type="text" class="input-text" name="username" id="username2" value="" />
                </label>
            </p>
                
            <p class="form-row form-row-wide">
                <label for="email2">Email Address:
                    <i class="im im-icon-Mail"></i>
                    <input type="text" class="input-text" name="email" id="email2" value="" />
                </label>
            </p>

            <p class="form-row form-row-wide">
                <label for="password1">Password:
                    <i class="im im-icon-Lock-2"></i>
                    <input class="input-text" type="password" name="password1" id="password1"/>
                </label>
            </p>

            <p class="form-row form-row-wide">
                <label for="password2">Repeat Password:
                    <i class="im im-icon-Lock-2"></i>
                    <input class="input-text" type="password" name="password2" id="password2"/>
                </label>
            </p>

            <input type="submit" class="button border fw margin-top-10" name="register" value="Register" />

            </form>
        </div>
        )
    }
}
export default Signup;