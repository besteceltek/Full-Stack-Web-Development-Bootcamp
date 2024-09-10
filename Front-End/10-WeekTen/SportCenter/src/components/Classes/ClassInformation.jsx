const ClassInformation = ({ type, classInfo }) => {
    return (
        <div className="content" id={type.fieldName} key={type.fieldName}>
            <div className={type.className}>
                <h3>{type.title}</h3>
                <ul>
                    {classInfo[type.fieldName].map((listItem) => {
                        return (
                            <li></li>
                        )
                    })}
                </ul>
            </div>
            <div className={type.imageClass}>
                
            </div>
        </div>
    )
}

export default ClassInformation

/*
<div class="content active" id="yoga">
    <div class="yoga-info">
        <h3>Yoga Classes</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quia error iure incidunt dolorum adipisci? Maiores porro ex, placeat itaque exercitationem velit, vitae cumque, rerum obcaecati repellendus iste! Illum, labore animi?</p>
        <h3>When is the Class Time?</h3>
        <ul>
            <li>Saturday-Sunday: 8:00am - 10:00am</li>
            <li>Monday-Tuesday: 10:00am - 12:00pm</li>
            <li>Wednesday-Friday: 3:00pm - 6:00pm</li>
        </ul>
    </div>
    <div class="yoga-image">
        <img src="/images/yoga.jpg" alt="">
    </div>
</div>
*/

/*
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
*/