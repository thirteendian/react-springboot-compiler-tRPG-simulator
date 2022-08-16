import React from 'react';

import "./index.css";

export default function Index(props) {
    return (
        <div>
            <input className={props.className}
                   onChange={props.onChange}
                   placeholder={props.placeholder}
                   value={props.value}
            />
        </div>
    );
}