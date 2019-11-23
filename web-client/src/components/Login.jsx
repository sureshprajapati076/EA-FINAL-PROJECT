import React , {Component} from 'react'
class Login extends Component{
    render(){
        return(
            <div classNameName="tab-content" id="tab1" style="display: none;" >
            <form method="post" classNameName="login">

                <p className="form-row form-row-wide">
                    <label for="username">Username:
                        <i className="im im-icon-Male"></i>
                        <input type="text" className="input-text" name="username" id="username" value="" />
                    </label>
                </p>

                <p className="form-row form-row-wide">
                    <label for="password">Password:
                        <i className="im im-icon-Lock-2"></i>
                        <input className="input-text" type="password" name="password" id="password"/>
                    </label>
                    <span className="lost_password">
                        <a href="#" >Lost Your Password?</a>
                    </span>
                </p>

                <div className="form-row">
                    <input type="submit" className="button border margin-top-5" name="login" value="Login" />
                    <div className="checkboxes margin-top-10">
                        <input id="remember-me" type="checkbox" name="check" />
                        <label for="remember-me">Remember Me</label>
                    </div>
                </div>
                
            </form>
        </div> 
        )
    }
}
export default Login;