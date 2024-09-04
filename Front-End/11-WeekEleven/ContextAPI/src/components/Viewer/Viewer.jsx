import React from 'react'
import { findItemByID } from '../../helpers/utils'
import Item from '../Item/Item'

const Viewer =({ parentFolderId, activeFolderId, list, changeFolder }) => {
  const data = findItemByID([list], activeFolderId)
  const handleBack = () => {
    changeFolder(parentFolderId)
  }
  return (
    <div>
      {parentFolderId && <button onClick={handleBack}>Back</button>}
      <div className='viewer'>
        {data?.subitems?.map(item => {
          return <Item
          key={item.id}
          id={item.id}
          changeFolder={changeFolder}
          title={item.title}
          type={item.type}
          image={item.image} />
        })}
      </div>
    </div>
  )
}

export default Viewer