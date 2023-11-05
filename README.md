<h1>Wisee(AR을 활용한 네트워크 시각화 앱)</h1>
</br>

<h2>앱 설명 포스터</h2>

![KakaoTalk_20231105_230748579](https://github.com/99andrew99/wisee/assets/66951806/84ab9985-7412-4c76-9703-b30f385c7d4e)

<h2>추진 배경</h2>
<p>스마트폰은 현대인의 필수품이다. 이 스마트폰을 사용하기 위해서는 인터넷 연결 즉, 와이파이 혹은 통신사의 통신망이 필요한데 통신사의 데이터 요금은 천정부지로 높아져 가고 공공와이파이는 느리고 잘 되지도 않아 스마트폰을 사용하는 사람들의 불편함이 늘어나게 되었다. 이에 비싼 데이터 요금 대신 무료인 공공와이파이를 빠르고 안정적이게 사용하고 싶어하는 사람들의 니즈를 파악하고, 이에 대한 솔루션을 제공하기 위해 다음과 같은 프로젝트를 추진하게 되었다. </p>


<h2>목표 및 내용</h2>
<p>
  목표)
대중들에게 한 장소에서 가장 좋은 와이파이를 선별 후 연결된 와이파이를 AR로 시각화하여 가장 최적의 위치를 직관적으로 제공하는 서비스를 목표로 합니다.

내용)
어플의 메인 기능은 주변 와이파이 정보 제공 및 최적의 와이파이 추천기능, 현재 연결된 와이파이의 정보 제공기능, AR을 이용하여 주변 와이파이 정보를 시각화해주는 기능, 시각화한 와이파이의 정보를 이용하여 HeatMap 구현하는 기능이 있습니다
</p>


<h2>기대 효</h2>
<p>
1. 와이파이 활용에 대한 편리성의 증대로 사용자에게 쾌적한 네트워크 환경을 제공해 줄 수 있다.

2. 와이파이를 선택하는 데에 있어 여러 선택지 중 최선의 선택을 종용하는 데에 도움을 줄 수 있다
</p>

<h2>세부 내</h2>
<p>
기존 어플과의 차별성)
</p>

  ![image](https://github.com/99andrew99/wisee/assets/66951806/213abfdb-0cca-4c55-bda8-3bf2190e5cd9)
  ![image](https://github.com/99andrew99/wisee/assets/66951806/40367c51-af43-4e0a-bcf7-08b991962af3)
<p>
  왼쪽은 fast.com은 가장 많은 사람들이 사용하는 속도 측정 사이트입니다. 단순히 현재 연결되어 있는 네트워크의 속도를 다운로드 속도로만 제공합니다. 
오른쪽은 speed test check로 앱스토어 내에 가장 최상단의 네트워크 측정 어플입니다. 타 어플에 비해 자세한 정보를 제공한다는 장점이 있습니다 .
하지만 두 어플, 사이트는 속도 혹은 중복도를 표현해 주는 것이 한계이고 네트워크 관련지식이 없다면 알아보기 힘듭니다. 
또한 와이파이라는 것은 위치, 즉 장애물의 위치나 건물의 상층, 하층 등 사용자의 위치에 따라 크게 달라지기 때문에 한계가 존재합니다. 따라서 이번 저희 프로젝트는 기존의 어플특성도 활용하지만 네트워크 지식이 없는 사람들도 좋은 와이파이를 골라 사용할 수 있게 하는 것이 저희 프로젝트의 핵심이고, 또한 AR을 통해 같은 장소라도 위치에 따라 다른 와이파이의 속도,감도 등을 측정 할 수 있어 가장 좋은 위치를 파악할 수 있음을 목표로 하였습니다.
</p>

<strong>
주요 기능)

1. 주변 와이파이 정보를 제공받아 최적의 와이파이를 추천해주는 기능
</strong>

<p>
  - 주변와이파이의 정보를 리스트화하여 사용자에게 제공하고 이를 간편하게 활용할 수 있게 감도와 주파수를 기준으로 최적의 와이파이를 선별하여 사용자에게 제공합니다. 감도와 주파수를 기준으로 선택한 이유는 일반적으로 주파수가 클수록 속도가 빠르고, 감도 또한 감도가 클수록 안정성이 높기 때문에 이를 기준으로 선정하였습니다.
</p>

![image](https://github.com/99andrew99/wisee/assets/66951806/c9a1dee7-5562-452b-9287-5578b629c437)

<strong>
2. 현재 와이파이 정보 제공
</strong>
<p>
  - 현재 와이파이에 대한 정보를 제공하고, 이에 따른 다양한 기능들을 사용자에게 제공합니다. AR 기능 활용, 현재 연결된 와이파이와 비교하여 근처 와이파이 정보 등을 목록과 아이콘을 통해 사용자에게 제공합니다.
</p>

![image](https://github.com/99andrew99/wisee/assets/66951806/a90619d7-4cbd-47ec-ba0e-156f285fe8d2)

<strong>
3. AR을 이용하여 연결된 와이파이 정보 시각화 기능
</strong>
<p>
  - 어플의 메인인 AR을 이용한 wifi 시각화 기능입니다. 화면에서 보이는 것과 같이 AR 기능을 사용하여 주변 환경을 보여주고, 연결된 와이파이를 기준으로 현재 위치의 wifi 정보(감도, 속도)를 제공합니다. 
</p>

![image](https://github.com/99andrew99/wisee/assets/66951806/8c812af5-8c92-40d2-915b-e4ad54d80d01)

<strong>
4. HeatMap 기능
</strong>
<p>
  - Heatmap이란 데이터의 값을 컬러로 변환시켜 시각적인 분석을 가능하게 하는 데이터 시각화 기법으로 육안으로 보이지 않는 와이파이를 AR 내부에서 컬러로 나타내어 감도와 속도가 강할수록 색이 푸른 빛으로 나타나게 하였습니다. 이를 통해 대부분의 wifi heatmap은 2d 평면화지만 이를 AR을 통해 3d로 표현하였습니다.
</p>

![image](https://github.com/99andrew99/wisee/assets/66951806/7a644e39-ff68-40bf-84c1-5a51bb8f53e1)
![image](https://github.com/99andrew99/wisee/assets/66951806/2991da16-4e57-48c1-b14c-da420aefdda9)


<h2>개발결과</h2>
<strong>1. 메인화면 </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/bdad795d-c6ad-4765-85ba-4ec7a626979e)


<strong>2. 현재 연결된 와이파이 </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/d377c20c-7c70-45e4-8837-39dd56b913f1)

<strong>3. 연결된 기능 </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/9408919b-0ce9-49f2-aa31-2a7d2aea394b)

<strong>4. 주변 와이파이 리스트 </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/0990843f-1f4a-47dd-b840-2eeaa0131bf3)

<strong>5. 최적의 와이파이 (감도, 주파수 기준) </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/99ce1dd5-ce7b-46d7-a194-3dd32d275bf1)

<strong>6. AR 시각화 기능 </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/745f5d68-b3f4-4fbb-9df1-21f90efce864)
![image](https://github.com/99andrew99/wisee/assets/66951806/9bb7fd38-3968-4192-b785-462113aeb880)

<strong>7. HeatMap </strong>

![image](https://github.com/99andrew99/wisee/assets/66951806/ca7a3896-2408-47d4-b9a3-1d347b6be9c1)



<h2>요구사항</h2>
<p>안드로이드 12.0(API 31이상): AR 구동 필요조건</p>
