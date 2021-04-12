var buildUrl = "Build";
var preLink = "/games/0/A tale about living pile of dirt"
      var loaderUrl = buildUrl + preLink + "/A tale about living pile of dirt.loader.js";
      var config = {
        dataUrl: buildUrl + preLink + "/A tale about living pile of dirt.data.gz",
        frameworkUrl: buildUrl + preLink + "/A tale about living pile of dirt.framework.js.gz",
        codeUrl: buildUrl + preLink + "/A tale about living pile of dirt.wasm.gz",
        streamingAssetsUrl: buildUrl + preLink + "StreamingAssets",
        companyName: "DefaultCompany",
        productName: "2DaysJam",
        productVersion: "0.1",
      };

      var container = document.querySelector("#unity-container");
      var canvas = document.querySelector("#unity-canvas");
      var loadingBar = document.querySelector("#unity-loading-bar");
      var progressBarFull = document.querySelector("#unity-progress-bar-full");
      var fullscreenButton = document.querySelector("#unity-fullscreen-button");

      if (/iPhone|iPad|iPod|Android/i.test(navigator.userAgent)) {
        container.className = "unity-mobile";
        config.devicePixelRatio = 1;
      } else {
        canvas.style.width = "960px";
        canvas.style.height = "600px";
      }
      loadingBar.style.display = "block";

      var script = document.createElement("script");
      script.src = loaderUrl;
      script.onload = () => {
        createUnityInstance(canvas, config, (progress) => {
          progressBarFull.style.width = 100 * progress + "%";
        }).then((unityInstance) => {
          loadingBar.style.display = "none";
          fullscreenButton.onclick = () => {
            unityInstance.SetFullscreen(1);
          };
        }).catch((message) => {
          alert(message);
        });
      };
      document.body.appendChild(script);