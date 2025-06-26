import json
import os

from PIL import Image
from tqdm import tqdm
from flask_cors import CORS
from flask import Flask, request
from unet import Unet
from utils.utils_metrics import compute_mIoU, show_results
app = Flask(__name__)
CORS(app)
@app.route('/miou',methods=['GET'])
def miou():

    miou_mode       = 2
    num_classes     = 2+1
    #--------------------------------------------#
    #   区分的种类，和json_to_dataset里面的一样
    #--------------------------------------------#
    name_classes    = ["_background_","lung","lesion"]
    VOCdevkit_path  = 'VOCdevkit'
    image_ids       = open(os.path.join(VOCdevkit_path, "VOC2007/ImageSets/Segmentation/val.txt"),'r').read().splitlines() 
    gt_dir          = os.path.join(VOCdevkit_path, "VOC2007/SegmentationClass/")
    miou_out_path   = "miou_out"
    pred_dir        = os.path.join(miou_out_path, 'detection-results')
    unet = Unet()

    for image_id in tqdm(image_ids):
        image_path  = os.path.join(VOCdevkit_path, "VOC2007/JPEGImages/"+image_id+".jpg")
        image       = Image.open(image_path)
        image       = unet.get_miou_png(image)
        image.save(os.path.join(pred_dir, image_id + ".png"))
    print("Get predict result done.")

    #if miou_mode == 0 or miou_mode == 2:
    print("Get miou.")
    #hist, IoUs, PA_Recall, Precision = compute_mIoU(gt_dir, pred_dir, image_ids, num_classes, name_classes)  # 执行计算mIoU的函数
    result=compute_mIoU(gt_dir, pred_dir, image_ids, num_classes, name_classes)
    return json.dumps(result)


if __name__ == "__main__":
    app.run(port=5001)