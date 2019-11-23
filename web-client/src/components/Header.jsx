import React , {Component} from 'react'
import { BrowserRouter as Router , Link , NavLink , Prompt } from 'react-router-dom'
import Route from 'react-router-dom/Route';
import AddAppartment from './AddAppartment'
class Header extends Component{
    render(){
        return(
        <React.Fragment>   
       
        <header id="header-container"  class="fixed fullwidth dashboard">

            { /*  <!-- Header   -- > */ }
            <div id="header">
                <div class="container">
                    
                    { /*  <!-- Left Side Content   -- > */ }
                    <div class="left-side">
                        
                        { /*  <!-- Logo   -- > */ }
                        <div id="logo">
                            <a href="index-2.html"><img src="images/logo2.png" data-sticky-logo="images/logo.png" alt="" /></a>
                        </div>
        
                        { /*  <!-- Mobile Navigation   -- > */ }
                        <div class="mmenu-trigger">
                            <button class="hamburger hamburger--collapse" type="button" >
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </button>
                        </div>
        
                        { /*  <!-- Main Navigation   -- > */ }
                        <nav id="navigation" class="style-1">
                            <ul id="responsive">
        
                                <li><a class="current" href="#">Home</a>
                                    <ul>
                                        <li><a href="index-2.html">Home 1</a></li>
                                        <li><a href="index-2-airbnb.html">Home 2 (Airbnb)</a></li>
                                        <li><a href="index-3.html">Home 3</a></li>
                                        <li><a href="index-4.html">Home 4</a></li>
                                        <li><a href="index-5.html">Home 5</a></li>
                                        <li><a href="index-6.html">Home 6</a></li>
                                    </ul>
                                </li>
        
                                
                                
                            </ul>
                        </nav>
                        <div class="clearfix"></div>
                        { /*  <!-- Main Navigation / End   -- > */ }
                        
                    </div>
                    { /*  <!-- Left Side Content / End   -- > */ }
        
        
                    { /*  <!-- Right Side Content / End   -- > */ }
                    <div class="right-side">
                        <div class="header-widget">
                            { /*  <!-- User Menu   -- > */ }
                            <div class="user-menu">
                                <div class="user-name"><span><img src="images/dashboard-avatar.jpg" alt=""/></span>Hi, Tom!</div>
                                <ul>
                                    <li><a href="dashboard.html"><i class="sl sl-icon-settings"></i> Dashboard</a></li>
                                    <li><a href="dashboard-messages.html"><i class="sl sl-icon-envelope-open"></i> Messages</a></li>
                                    <li><a href="dashboard-bookings.html"><i class="fa fa-calendar-check-o"></i> Bookings</a></li>
                                    <li><a href="index-2.html"><i class="sl sl-icon-power"></i> Logout</a></li>
                                </ul>
                            </div>
        
                            <a href="#sign-in-dialog" class="sign-in popup-with-zoom-anim"><i class="sl sl-icon-login"></i> Sign In</a>
                           {/* <NavLink to="/addlist" className="button border with-icon">Add Appartment </NavLink> */}
                        </div>
                    </div>
                    { /*  <!-- Right Side Content / End   -- > */ }
        
                    { /*  <!-- Sign In Popup   -- > */ }
                    <div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">
        
                        <div class="small-dialog-header">
                            <h3>Sign In</h3>
                        </div>
        
                        { /*  <!--Tabs   -- > */ }
                        <div class="sign-in-form style-1">
        
                            <ul class="tabs-nav">
                                <li class=""><a href="#tab1">Log In</a></li>
                                <li><a href="#tab2">Register</a></li>
                            </ul>
        
                            <div class="tabs-container alt">
        
                                { /*  <!-- Login   -- > */ }
                                <div class="tab-content" id="tab1" style={{display:"none"}}>
                                    <form method="post" class="login">
        
                                        <p class="form-row form-row-wide">
                                            <label for="username">Username:
                                                <i class="im im-icon-Male"></i>
                                                <input type="text" class="input-text" name="username" id="username" value="" />
                                            </label>
                                        </p>
        
                                        <p class="form-row form-row-wide">
                                            <label for="password">Password:
                                                <i class="im im-icon-Lock-2"></i>
                                                <input class="input-text" type="password" name="password" id="password"/>
                                            </label>
                                            <span class="lost_password">
                                                <a href="#" >Lost Your Password?</a>
                                            </span>
                                        </p>
        
                                        <div class="form-row">
                                            <input type="submit" class="button border margin-top-5" name="login" value="Login" />
                                            <div class="checkboxes margin-top-10">
                                                <input id="remember-me" type="checkbox" name="check" />
                                                <label for="remember-me">Remember Me</label>
                                            </div>
                                        </div>
                                        
                                    </form>
                                </div>
        
                                { /*  <!-- Register   -- > */ }
                                <div class="tab-content" id="tab2" style={{display:"none"}}>
        
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
        
                            </div>
                        </div>
                    </div>
                    { /*  <!-- Sign In Popup / End   -- > */ }
        
                </div>
            </div>
        
            { /*  <!-- Header / End   -- > */ }
        
        </header>  
        {this.props.children}

      
        </React.Fragment> 
        )
    }
}
export default Header;