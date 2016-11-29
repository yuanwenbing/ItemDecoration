# ItemDecoration
# Use
	// 居中
	mDecoration = new VerticalItemDecoration.Builder().showStart(true).showEnd(true).paddingLeft(50).paddingRight(20).color(Color.BLUE).size(10).build();
	// 水平
	mDecoration = new HorizontalItemDecoration.Builder().showStart(false).showEnd(true).paddingBottom(50).paddingTop(20).color(Color.RED).size(10).build();
	mRecyclerView.addItemDecoration(mDecoration);

