import React, {Component} from 'react';
import Header from "../Header";
import InputText from "../InputText";
import Items from "../Items";

class Index extends Component {

    render() {
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
}

export default Index;