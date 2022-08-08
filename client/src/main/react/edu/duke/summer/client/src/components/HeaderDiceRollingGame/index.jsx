import React, {Component} from 'react';
import "./index.css";
import ButtonNavigation from"../ButtonNavigation"

class Index extends Component {
    render() {
        return (
            <div>
                <div className="head_container_dice_rolling_game">
                    <h1 className="head_dice_rolling_game">
                        {this.props.content}
                    </h1>
                    <ButtonNavigation/>
                </div>
            </div>
        );
    }
}

export default Index;