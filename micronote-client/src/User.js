import {Component} from "react";
import {Button} from "reactstrap";
import {Link} from "react-router-dom";

class User extends Component {
    state = {
        users: [{
            notes: []
        }]
    };

    async componentDidMount() {
        const response = await fetch('/api/v1/user');
        const body = await response.json();
        this.setState({users: body});
    }


    render() {
        const {users} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <div className="App-intro">
                        <h2>User</h2>
                        {users.map(user =>
                            <div key={user.id}>
                                {user.username} {user.password}
                                {
                                    user.notes.map(note =>
                                        (<p> Notes: {note.id}, {note.content}
                                        </p>)
                                    )
                                }
                                <Button color="link"><Link to={`/user/${user.id}`}>User</Link></Button>
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }

}

export default User;