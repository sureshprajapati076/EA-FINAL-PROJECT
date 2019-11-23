import React, { Component } from 'react';
import DashboardSidebar from './DashboardSidebar';
import DashboardContent from './DashboardContent'
class Dashboard extends Component {
    state = {  }
    render() { 
        return ( 
          
            <div id="dashboard" >
            
                <a href="#" class="dashboard-responsive-nav-trigger"><i class="fa fa-reorder"></i> Dashboard Navigation</a>
                
                <DashboardSidebar></DashboardSidebar>
                <DashboardContent></DashboardContent>
            

            
            
            </div>
    
            
         );
    }
}
 
export default Dashboard;