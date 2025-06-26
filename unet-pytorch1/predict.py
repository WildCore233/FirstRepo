
import time

import cv2
import numpy as np
from PIL import Image
from flask_cors import CORS
from flask import Flask, request ,send_file
from openai import OpenAI

from unet import Unet
import random
import os
import io
app = Flask(__name__)
CORS(app)

def get_bytes(r_image):
    save_path = r'D:\graduate\Python\TrainPicture\result'
    save_name = str(random.sample('zyxwvutsrqponmlkjihgfedcba',5))+'.png'
    final_path = os.path.join(save_path,save_name)
    r_image.save(final_path)
    img = Image.open(final_path)
    bytes_io = io.BytesIO()
    img.save(bytes_io,format='PNG')
    return  bytes_io.getvalue()
@app.route('/unet',methods=['POST'])

def apart():
    img = request.files['file']
    count           = False
    name_classes = ["background", "lung", "lesion"]
    test_interval = 100
    simplify        = True
    onnx_save_path  = "model_data/models.onnx"
    unet = Unet()
    try:
        image = Image.open(img)
    except:
        print('Open Error! Try again!')

    r_image = unet.detect_image(image, count=count, name_classes=name_classes)
    return get_bytes(r_image)





@app.route("/Qwen",methods = ['GET'])
def analyse():
    obj_url = request.args.get('filePath')
    print(obj_url)

    client = OpenAI(
        api_key=os.getenv("DASHSCOPE_API_KEY"),
        base_url="https://dashscope.aliyuncs.com/compatible-mode/v1"
    )
    completion = client.chat.completions.create(
        model='qwen-vl-max-latest',
        messages=[

            {
                "role": "user",
                "content": [
                    {
                        "type": "text","text": "分析该肺部x光图像，输出的文本为一整段文字"},
                    {
                        "type": "image_url", "image_url": {"url": obj_url}},

                ],
            },
        ],
    )

    return completion.model_dump_json()

if __name__ == "__main__":
    app.run()
