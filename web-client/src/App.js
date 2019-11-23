import React, { Component } from "react";
import {
  BrowserRouter as Router,
  Link,
  NavLink,
  Prompt,
  Redirect
} from "react-router-dom";
import Route from "react-router-dom/Route";
import logo from "./logo.svg";
import Home from "./components/Home";
import AddAppartment from "./components/AddAppartment";
import ListAppartments from "./components/ListAppartments";
import SingleAppartment from "./components/SingleAppartment";
import BookAppartment from "./components/BookAppartment";
import Messages from "./components/Messages";
import Bookings from "./components/Bookings";
import Payments from "./components/Payments";
import Listings from "./components/Listings";
import Reviews from "./components/Reviews";
import Header from "./components/Header";
import axios from "axios";
//import './App.css';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: null,
      searchQuery: "",
      redirect: false,
      results: []
    };

    this.onSearchQueryChange = this.onSearchQueryChange.bind(this);
    this.onSearch = this.onSearch.bind(this);
  }

  onSearchQueryChange(e) {
    this.setState({ searchQuery: e.target.value });
  }

  onSearch() {
    console.log("search button clicked");
    // axios call
    axios({
      url: "http://localhost:8080/graphql",
      method: "post",
      data: {
        query: `
          query {
            apartments(count: 2) 
            {
              id, 
              title, 
              details,
              imageUrl
          }
          }
            `
      }
    }).then(result => {
      this.setState({ results: result.data.data.apartments });
      console.log(result.data);
    });
    // setTimeout(() => {

    //   this.setState({results: [0, 1, 2, 3, 4]});
    // }, 1000)
    this.setRedirect();
  }

  setRedirect = () => {
    this.setState({
      redirect: true
    });
  };

  renderRedirect = () => {
    if (this.state.redirect) {
      return <Redirect to="/list" />;
    }
  };

  render() {
    const { results, searchQuery } = this.state;
    return (
      <React.Fragment>
        <Router>
          {this.renderRedirect()}
          <Route
            exact
            path="/"
            render={props => (
              <Home
                {...props}
                searchQuery={searchQuery}
                onChange={this.onSearchQueryChange}
                search={this.onSearch}
              />
            )}
          />

          <Route exact path="/addlist" component={AddAppartment} />
          <Route
            exact
            path="/list"
            render={props => (
              <ListAppartments
                {...props}
                results={results}
                searchQuery={searchQuery}
              />
            )}
          />
          <Route exact path="/single" component={SingleAppartment} />
          <Route exact path="/book" component={BookAppartment} />
          <Route exact path="/messages" component={Messages} />
          <Route exact path="/bookings" component={Bookings} />
          <Route exact path="/payments" component={Payments} />
          <Route exact path="/listings" component={Listings} />
          <Route exact path="/reviews" component={Reviews} />
        </Router>
      </React.Fragment>
    );
  }
}

export default App;
