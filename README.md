# Android开发重要模块

Android核心模块功能实现总结。
## Recyclerview相关

### 自定义ItemDecoration

- 自定义类SelectionItemDecoration继承自RecyclerView.ItemDecoration
- 重写getItemOffsets()
- 重写onDraw()
- 重写onDrawOver()

### 自定义ItemAnimator

- 自定义类MyItemAnimator继承自SimpleItemAnimator(SimpleItemAnimator时抽象类，继承自RecyclerView.ItemAnimator)
- 实现几个必须要实现的方法：animateAdd()、animateRemove()、animateMove()、animateChange()
- 在animateAdd()中添加加载动画代码

```java
@Override
public boolean animateAdd(RecyclerView.ViewHolder holder) {
    //1、获取Animator对象
    Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.zoom_in);
    //2、用于计算动画已用部分的时间插值器
    animator.setInterpolator(new BounceInterpolator());
    //3、设置添加动画目标对象
    animator.setTarget(holder.itemView);
    //4、动画开始
    animator.start();
    return true;
}
```
### 自定义LayoutManager

- 计算每个ItemView的位置

(1)重写onLayoutChildren()

- 处理滑动事件

(1)canScrollHorizontally();
(2)canScrollVertically();
(3)scrollHorizontallyBy();
(4)scrollVerticallyBy();

- 缓存并重用ItemView

实现缓存最主要的就是先把每个ItemView的位置信息保存起来，然后在滑动过程中通过判断每个ItemView的位置是否和当前RecyclerView应该显示的区域有重合，若有就显示它，若没有就移除并回收。
```java
/**
 * 保存item的位置信息
 */
private SparseArray<Rect> allItemRects = new SparseArray<>();
/**
 * 保存item是否处于可见状态的信息
 */
private SparseBooleanArray itemStates = new SparseBooleanArray();
```

## ListView相关


## ViewPager相关


## 轮播图的实现

### 轮播图需求汇总

- 支持多张图片定时轮播
- 支持多图集首尾轮播
- 支持轮播图图片点击事件
- 自定义指示器(位置、颜色、样式)
- 能够实现自定义图片加载框架
- 实现轮播图开始、停止、销毁等功能

### 实现思路

- 使用ViewPager

重写PagerAdapter中的方法：

(1)getCount()
(2)isViewFromObject()
(3)instantiateItem()
(4)destroyItem()

ViewPager.addOnPageChangeListener()重写：

(1)onPageScrolled()
(2)onPageSelected()
(3)onPageScrollStateChanged()处理三个状态：

SCROLL_STATE_DRAGGING：手指滑动状态
SCROLL_STATE_IDLE：停止状态
SCROLL_STATE_SETTLING：自动滑动状态

- 使用RecyclerView

(1)给适配器设置为无限大
(2)然后将初始位置通过 scrollToPosition() 定位在中间某个地方,完全不用担心像使用ViewPager一样的ANR问题
(3)通过定时器,每隔一定事件调用smoothScrollToPosition()
(4)刷新的时候,通过 notifyDataSetChanged()更新数据,不用每次再重新设置适配器了


## 自实现图片加载框架ImageLoader


## 底部四个Bar实现


## Listview或RecyclerView列表头部吸附顶部实现


## 使用RxJava、MVP、Dagger2、Retrofit搭建开发框架


## ListView或RecyclerView中使用CheckBox的各种场景


## 项目的模块化、插件化