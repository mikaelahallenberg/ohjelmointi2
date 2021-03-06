async function removeArtist(id, artistName) {
   const confirmation = confirm(`Are you sure you want to remove artist ${artistName}?`);
   if (confirmation) {
       const response = await fetch(`/artists?id=${id}`, { method: "DELETE" });

       if (response.status === 200) {
           return document.getElementById(`artist-${id}`).remove();
       }
       alert("Could not remove artist");
   }
}