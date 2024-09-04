import React from 'react'
import folderIcon from '../../assets/folder.png'

const Item = ({ id, title, type, image, changeFolder }) => {
  const handleDblClick = () => {
    if (type === "folder") {
      changeFolder(id)
    }
  }
  const imgSrc = type === "folder" ? folderIcon : image
  const imgCls = type === "folder" ? "folder-img" : "image"
  return (
    <div className='viewer-item' onDoubleClick={handleDblClick}>
      <img className={imgCls} src={imgSrc} alt="" />
      {title}
    </div>
  )
}

export default Item