import axios from 'axios';
import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

function SignUp() {
    const url = 'http://localhost:8080/home/sign-up';
    const [data, setData] = useState({
        username: '',
        email: '',
        password: ''
    });

    const [message, setMessage] = useState()

    function handleChange(e) {
        const newData = { ...data };
        newData[e.target.id] = e.target.value;
        setData(newData);
    }

    function handleSubmit(e) {
        e.preventDefault();
        axios.post(url, {
            username: data.username,
            email: data.email,
            password: data.password
        })
        .then(res => {
            console.log(res.data);
            setMessage(res.data.message);
        })
        .catch(err => {
            console.error(err);
        });
    }

    return (
        <div className="container mt-5">
            <h2 className="text-center">Sign Up</h2>
            <form onSubmit={handleSubmit} className="mt-4">
                <div className="mb-3">
                    <label htmlFor="username" className="form-label">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="username"
                        value={data.username}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        value={data.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        value={data.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary w-100">Sign Up</button>
            </form>
            <div className="mt-3">
                <h3>{message}</h3>
            </div>
        </div>
    );
}

export default SignUp;