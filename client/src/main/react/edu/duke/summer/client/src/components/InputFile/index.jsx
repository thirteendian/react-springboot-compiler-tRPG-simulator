import React, {Component} from 'react';
import "./index.css";

class Index extends Component {

    render() {
        return (
            <div>
                <input className = {this.props.classNameInput} type="file" onChange={this.props.onFileChange}/>
                <button className={this.props.classNameButton} onClick={this.props.onFileClick}>Upload</button>
            </div>
        );
    }
}

export default Index;