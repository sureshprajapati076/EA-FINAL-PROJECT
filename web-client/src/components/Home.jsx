import React, { Component } from "react";
import Header from "./Header";
import Banner from "./Banner";
import MostVisted from "./MostVisited";
import Footer from './Footer'
const Home = (props) => {
  const {
    searchQuery,
    onChange,
    search
  } = props
  
    console.log(search)
    return (
      <React.Fragment>
        <Header ></Header>
        
        
        <div class="main-search-container centered" data-background-image="images/main-search-background-01.jpg" >
            <div class="main-search-inner">
          
              <div class="container">
                <div class="row">
                  <div class="col-md-12">
                    <h2>
                      Find Nearby 
                      { /* <!-- Typed words can be configured in script settings at the bottom of this HTML file  --> */ }
                      <span class="typed-words"></span>
                    </h2>
                    <h4>Expolore top-rated attractions, activities and more</h4>
          
                    <div class="main-search-input">
          
                      <div class="main-search-input-item">
                        <input type="text" placeholder="What are you looking for?"  value={searchQuery}
      onChange={onChange}/>
                      </div>
          
                      <div class="main-search-input-item location">
                        <div id="autocomplete-container">
                          <input id="autocomplete-input" type="text" placeholder="Location" />
                        </div>
                        <a href="#"><i class="fa fa-map-marker"></i></a>
                      </div>
        
          
                      <button class="button" onClick={search}>Search</button>
          
                    </div>
                  </div>
                </div>
              
          
              </div>
          
            </div>
          </div>

        <MostVisted></MostVisted>
        <Footer></Footer>
      </React.Fragment>
    );
  
}

export default Home;
