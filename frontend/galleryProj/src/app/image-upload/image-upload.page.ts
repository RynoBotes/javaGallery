import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalController, ToastController } from '@ionic/angular';
import { BASE_API_URL } from 'src/environments/environment';
import {  FormGroup, ReactiveFormsModule } from '@angular/forms';
import { GalleryPage } from '../gallery/gallery.page';

const profile = <HTMLInputElement>document.getElementById("profile");

@Component({
  selector: 'app-image-upload',
  templateUrl: './image-upload.page.html',
  styleUrls: ['./image-upload.page.scss'],
})
export class ImageUploadPage implements OnInit{
    
  back()
  {
   this.modalController.dismiss();
  }
  constructor(private modalController:ModalController, private httpClient: HttpClient, private toastCtrl:ToastController) {
    
   }
   ngOnInit() {
    
  }
  // onFileSelect(event) {
  //   if (event.target.files.length > 0) {
  //     const file = event.target.files[0];
  //     uploadForm.get(profile).setValue(file);
  //   }
  // }
  
  async gallery()
  {
  
   const modal = await this.modalController.create(
   {
     component: GalleryPage,
     cssClass:'modal-fullscreen',
     id:'GalleryPage'
   });
    return await modal.present();
 
 }

uploadbtn = () =>{
  let image = (<HTMLInputElement>document.getElementById("profile")).files[0];
  let formData = new FormData();
     
formData.append("file", image);
fetch(BASE_API_URL+'photo-map/uploadImage', {method: 'POST', body: formData})

this.presentSuccessToast();

     ////////////////////
    //  this.gallery();
}


  addphoto= ()=>{
  
  let photo ={
    id:  (<HTMLInputElement>document.getElementById('memberId')).value,
   photoName: (<HTMLInputElement>document.getElementById('photoName')).value,
   photoDiscription: (<HTMLInputElement>document.getElementById('photoDescription')).value
  }
    
  
    fetch(BASE_API_URL+"photo-map",{method:'POST',body: JSON.stringify(photo),headers: {
      'Content-type': 'application/json; charset=UTF-8'
    }
  }).then(function (response) {
    if (response.ok) {
      return response.json();
    }
    return Promise.reject(response);
  }).then(function (data) {
    console.log(data);
  }).catch(function (error) {
    console.warn('Something went wrong.', error);
  });;
  
  
  
  }
  async presentSuccessToast() 
{
  let toast = this.toastCtrl.create(
  {
    message: 'Photo uploaded!',
    duration: 3000,
    position: 'bottom',
    color: "success"
  });
  return (await toast).present();
}

  deletePhoto = () =>{
    let id;

    id = (<HTMLInputElement>document.getElementById('photoId')).value,


    fetch(BASE_API_URL+"photo-map/delete/"+id, {headers: {
    'Content-type': 'application/json; charset=UTF-8'
  }
})
.then(res => res.text()) // or res.json()
.then(res => console.log(res))
  }

}
