import React, { Component } from "react";
import storage from "../firebase/index";

class DashboardContent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      image: null,
      url: "",
      progress: 0
    };
  }

  handleChange = e => {
    if (e.target.files[0]) {
      const image = e.target.files[0];
      this.setState(() => ({ image }));
    }
  };

  handleUpload = () => {
    const { image } = this.state;
    const uploadTask = storage.ref(`images/${image.name}`).put(image);
    uploadTask.on(
      "state_changed",
      snapshot => {
        // progress function ...
        const progress = Math.round(
          (snapshot.bytesTransferred / snapshot.totalBytes) * 100
        );
        this.setState({ progress });
      },
      error => {
        // Error function ...
        console.log(error);
      },
      () => {
        // complete function ...
        storage
          .ref("images")
          .child(image.name)
          .getDownloadURL()
          .then(url => {
            this.setState({ url });
          });
      }
    );
  };
  render() {
    return (
      <div className="dashboard-content">
        <div id="titlebar">
          <div className="row">
            <div className="col-md-12">
              <h2>Add Listing</h2>
              {/* <!--  Breadcrumbs  --> */}
              <nav id="breadcrumbs">
                <ul>
                  <li>
                    <a href="#">Home</a>
                  </li>
                  <li>
                    <a href="#">Dashboard</a>
                  </li>
                  <li>Add Appartment</li>
                </ul>
              </nav>
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-lg-12">
            <div id="add-listing">
              {/* <!--  Section  --> */}
              <div className="add-listing-section">
                {/* <!--  Headline  --> */}
                <div className="add-listing-headline">
                  <h3>
                    <i className="sl sl-icon-doc"></i> Basic Informations
                  </h3>
                </div>

                {/* <!--  Title  --> */}
                <div className="row with-forms">
                  <div className="col-md-12">
                    <h5>
                      Listing Title{" "}
                      <i
                        className="tip"
                        data-tip-content="Name of your business"
                      ></i>
                    </h5>
                    <input className="search-field" type="text" value="" />
                  </div>
                </div>

                {/* <!--  Row  --> */}
                <div className="row with-forms">
                  {/* <!--  Status  --> */}
                  <div className="col-md-6">
                    <h5>Category</h5>
                    <select className="chosen-select-no-single">
                      <option label="blank">Select Category</option>
                      <option>Appartemt</option>
                      <option>House</option>
                      <option>Hotel</option>
                    </select>
                  </div>

                  {/* <!--  Type  --> */}
                  <div className="col-md-6">
                    <h5>
                      Keywords{" "}
                      <i
                        className="tip"
                        data-tip-content="Maximum of 15 keywords related with your business"
                      ></i>
                    </h5>
                    <input
                      type="text"
                      placeholder="Keywords should be separated by commas"
                    />
                  </div>
                </div>
                {/* <!--  Row / End  --> */}
              </div>
              {/* <!--  Section / End  --> */}

              {/* <!--  Section  --> */}
              <div className="add-listing-section margin-top-45">
                {/* <!--  Headline  --> */}
                <div className="add-listing-headline">
                  <h3>
                    <i className="sl sl-icon-location"></i> Location
                  </h3>
                </div>

                <div className="submit-section">
                  {/* <!--  Row  --> */}
                  <div className="row with-forms">
                    {/* <!--  City  --> */}
                    <div className="col-md-6">
                      <h5>City</h5>
                      <select className="chosen-select-no-single">
                        <option label="blank">Select City</option>
                        <option>New York</option>
                        <option>Los Angeles</option>
                        <option>Chicago</option>
                        <option>Houston</option>
                        <option>Phoenix</option>
                        <option>San Diego</option>
                        <option>Austin</option>
                      </select>
                    </div>

                    {/* <!--  Address  --> */}
                    <div className="col-md-6">
                      <h5>Address</h5>
                      <input type="text" placeholder="e.g. 964 School Street" />
                    </div>

                    {/* <!--  City  --> */}
                    <div className="col-md-6">
                      <h5>State</h5>
                      <input type="text" />
                    </div>

                    {/* <!--  Zip-Code  --> */}
                    <div className="col-md-6">
                      <h5>Zip-Code</h5>
                      <input type="text" />
                    </div>
                  </div>
                  {/* <!--  Row / End  --> */}
                </div>
              </div>
              {/* <!--  Section / End  --> */}

              {/* <!--  Section  --> */}
              <div className="add-listing-section margin-top-45">
                {/* <!--  Headline  --> */}
                <div className="add-listing-headline">
                  <h3>
                    <i className="sl sl-icon-picture"></i> Gallery
                  </h3>
                </div>

                {/* <!--  Dropzone  --> */}
                <div className="submit-section">
                  <form
                    action="http://www.vasterad.com/file-upload"
                    className="dropzonex"
                  >
                    <input type="file" onChange={this.handleChange} />
                    <input type="file" />
                  </form>
                  <div className="row">
                    <progress
                      value={this.state.progress}
                      max="100"
                      className="progress"
                    />
                  </div>
                  <button onClick={this.handleUpload}>Upload</button>

                  <img
                    src={
                      this.state.url || "https://via.placeholder.com/400x300"
                    }
                    alt="Uploaded Images"
                    height="150"
                    width="100"
                  />
                </div>
              </div>
              {/* <!--  Section / End  --> */}

              {/* <!--  Section  --> */}
              <div className="add-listing-section margin-top-45">
                {/* <!--  Headline  --> */}
                <div className="add-listing-headline">
                  <h3>
                    <i className="sl sl-icon-docs"></i> Details
                  </h3>
                </div>

                {/* <!--  Description  --> */}
                <div className="form">
                  <h5>Description</h5>
                  <textarea
                    className="WYSIWYG"
                    name="summary"
                    cols="40"
                    rows="3"
                    id="summary"
                    spellcheck="true"
                  ></textarea>
                </div>

                {/* <!--  Row  --> */}
                <div className="row with-forms">
                  {/* <!--  Phone  --> */}
                  <div className="col-md-4">
                    <h5>
                      Phone <span>(optional)</span>
                    </h5>
                    <input type="text" />
                  </div>

                  {/* <!--  Website  --> */}
                  <div className="col-md-4">
                    <h5>
                      Website <span>(optional)</span>
                    </h5>
                    <input type="text" />
                  </div>

                  {/* <!--  Email Address  --> */}
                  <div className="col-md-4">
                    <h5>
                      E-mail <span>(optional)</span>
                    </h5>
                    <input type="text" />
                  </div>
                </div>
                {/* <!--  Row / End  --> */}

                {/* <!--  Row / End  --> */}

                {/* <!--  Checkboxes  --> */}
                <h5 className="margin-top-30 margin-bottom-10">
                  Amenities <span>(optional)</span>
                </h5>
                <div className="checkboxes in-row margin-bottom-20">
                  <input id="check-a" type="checkbox" name="check" />
                  <label for="check-a">Elevator in building</label>

                  <input id="check-b" type="checkbox" name="check" />
                  <label for="check-b">Friendly workspace</label>

                  <input id="check-c" type="checkbox" name="check" />
                  <label for="check-c">Instant Book</label>

                  <input id="check-d" type="checkbox" name="check" />
                  <label for="check-d">Wireless Internet</label>

                  <input id="check-e" type="checkbox" name="check" />
                  <label for="check-e">Free parking on premises</label>

                  <input id="check-f" type="checkbox" name="check" />
                  <label for="check-f">Free parking on street</label>

                  <input id="check-g" type="checkbox" name="check" />
                  <label for="check-g">Smoking allowed</label>

                  <input id="check-h" type="checkbox" name="check" />
                  <label for="check-h">Events</label>
                </div>
                {/* <!--  Checkboxes / End  --> */}
              </div>
              {/* <!--  Section / End  --> */}

              {/* <!--  Section  --> */}
              <div className="add-listing-section margin-top-45">
                {/* <!--  Headline  --> */}
                <div className="add-listing-headline">
                  <h3>Pricing</h3>
                  {/* <!--  Switcher  --> */}
                  <label className="switch">
                    <input type="checkbox" checked />
                    <span className="slider round"></span>
                  </label>
                </div>

                {/* <!--  Switcher ON-OFF Content  --> */}
                <div className="switcher-content">
                  <div className="row">
                    <div className="col-md-12">
                      <table id="pricing-list-container">
                        <tr className="pricing-list-item pattern">
                          <td>
                            <div className="fm-move">
                              <i className="sl sl-icon-cursor-move"></i>
                            </div>
                            <div className="fm-input pricing-name">
                              <input type="text" placeholder="Title" />
                            </div>
                            <div className="fm-input pricing-ingredients">
                              <input type="text" placeholder="Description" />
                            </div>
                            <div className="fm-input pricing-price">
                              <input
                                type="text"
                                placeholder="Price"
                                data-unit="USD"
                              />
                            </div>
                            <div className="fm-close">
                              <a className="delete" href="#">
                                <i className="fa fa-remove"></i>
                              </a>
                            </div>
                          </td>
                        </tr>
                      </table>
                      <a href="#" className="button add-pricing-list-item">
                        Add Item
                      </a>
                      <a href="#" className="button add-pricing-submenu">
                        Add Category
                      </a>
                    </div>
                  </div>
                </div>
                {/* <!--  Switcher ON-OFF Content / End  --> */}
              </div>
              {/* <!--  Section / End  --> */}

              <a href="#" className="button preview">
                Preview <i className="fa fa-arrow-circle-right"></i>
              </a>
            </div>
          </div>

          {/* <!--  Copyrights  --> */}
          <div className="col-md-12">
            <div className="copyrights">
              © 2019 Listeo. All Rights Reserved.
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default DashboardContent;
