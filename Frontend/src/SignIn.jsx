import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const SignIn = () => {
    const [data, setData] = useState({
        email:"",
        password:""
    });

    function handleChange(e) {
        const newData = { ...data };
        newData[e.target.id] = e.target.value;
        setData(newData);
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        
    };

    return (
        <div className="container mt-5">
            <h2 className="text-center">Log In</h2>
            <form onSubmit={handleSubmit} className="mt-4">
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
                <button type="submit" className="btn btn-primary w-100">Log In</button>
            </form>
        </div>
    );
};

export default SignIn;