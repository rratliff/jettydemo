import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import $ from 'jquery';

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {coffee: [], message: ''};
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    this.Coffee();
  }

  handleChange(event) {
    this.setState({message: event.target.value});
  }

  handleSubmit(event) {
    this.Coffee(this.state.message);
    event.preventDefault();
  }

  Coffee(message) {
    return $.ajax({
      type: "POST",
      dataType: "json",
      url: 'api/Coffee?' + $.param({message: message})
    }).then((data) => {
      console.log(data);
      this.setState({coffee: data});
    });
  }

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <form onSubmit={this.handleSubmit}>
          <label>
            Message:
            <input type="text" value={this.state.message} onChange={this.handleChange} />
          </label>
          <input type="submit" value="Submit" />
        </form>
        <p className="App-intro">
          {this.state.coffee.message}
        </p>
      </div>
    );
  }
}

export default App;
