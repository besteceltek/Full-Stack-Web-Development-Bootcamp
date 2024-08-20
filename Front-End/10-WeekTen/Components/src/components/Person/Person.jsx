const data = {
    avatar: "https://i.pravatar.cc/150",
    name: "John Doe",
    phoneNumbers: [
        { name: "home", number: "123456789"},
        { name: "work", number: "987654321"}
    ],
    addresses: [
        { name: "home", address: "1234 Main St"},
        { name: "work", address: "5678 Main St"}
    ],
    emails: [
        { name: "personal", email: "john@doe.com"},
        { name: "work", email: "john@cme.com"}
    ]
};

const Person = () => {
    return (
        <div>
            <img className="person-avatar" src={data.avatar} alt={data.name} />
            <h1 className="person-name">{data.name}</h1>
            <div>
                <h2>Phone Numbers</h2>
                <ul>
                    {}
                </ul>
            </div>
        </div>
    )    
};

export default Person