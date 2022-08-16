import React, {Component} from 'react';
import Header from "../Header";
import InputText from "../InputText";
import Items from "../Items";

export default function Index(props){

        const {toarray} = this.props;
        return (
            <div>
                <ul >
                    {
                        toarray.map((array)=>{
                                return  <Items/>
                            })
                    }

                </ul>

            </div>
        );
}
