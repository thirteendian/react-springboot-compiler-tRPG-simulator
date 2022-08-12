import React, {Component} from 'react';
import"./index.css";

class Index extends Component {
    render() {
        return (
            <div>
                <input type={"password"} className={this.props.className} onChange={this.props.onChange} placeholder={this.props.placeholder}/>
            </div>
        );
    }
}

export default Index;