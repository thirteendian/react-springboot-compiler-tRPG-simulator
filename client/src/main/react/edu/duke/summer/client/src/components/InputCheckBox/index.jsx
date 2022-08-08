import React, {Component} from 'react';
import "./index.css";

class Index extends Component {
    render() {
        return (
            <div>
                <input className={this.props.className} type={"checkbox"} onChange={this.props.onChange}/>
            </div>
        );
    }
}

export default Index;