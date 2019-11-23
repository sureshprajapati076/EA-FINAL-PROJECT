import React, { Component } from "react";
import Header from "./Header";
import Dashboard from "./Dashboard";
class AddAppartment extends Component {

  state = {};
  render() {
    return (
      <React.Fragment>
        <Header></Header>
        <Dashboard></Dashboard>
      </React.Fragment>
    );
  }
}

export default AddAppartment;
