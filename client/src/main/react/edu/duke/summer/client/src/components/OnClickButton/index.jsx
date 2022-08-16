import React, {Component} from 'react';
import "./index.css";

export  default class Index extends Component {
    render() {
        return (
            <div>
                <button className={this.props.className}
                        onClick={this.props.onClick}
                        disabled={this.props.disabled}
                >
                    {this.props.children}
                </button>
            </div>
        );
    }
}