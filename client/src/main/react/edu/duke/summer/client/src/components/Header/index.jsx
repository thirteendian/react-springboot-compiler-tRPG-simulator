import React, {Component} from 'react';
import "./index.css";
class Index extends Component {
    render() {
        return (
            <div>
                <div className={this.props.className}>
                    <h1>{this.props.children}</h1>
                </div>
            </div>
        );
    }
}

export default Index;