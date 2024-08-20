const PersonInformation = ({ personData, listType }) => {
    return (
        <div key={listType.fieldname} className="person-list-entry">
            <h2 className="list-type">{listType.title}</h2>
            <ul>
                {personData[listType.fieldname].map((listItem) => {
                    return (
                        <li key={listItem[listType.labelField]}>
                            <span className="list-label">{listItem[listType.labelField]} :</span>
                            <span className="list-value">{listItem[listType.valueField]}</span>
                        </li>
                    )
                })}
            </ul>
        </div>
    )
}

export default PersonInformation