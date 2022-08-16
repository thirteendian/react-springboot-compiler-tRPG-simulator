import React from 'react';
import "./index.css";

export default function Index (props){

        return (
            <div>
                <input className = {props.classNameInput} type="file" onChange={props.onChange}/>
                {/*<button className={this.props.classNameButton} onClick={this.props.onFileClick}>Upload</button>*/}
            </div>
        );
}
