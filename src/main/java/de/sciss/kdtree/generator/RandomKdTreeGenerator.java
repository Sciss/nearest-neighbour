package de.sciss.kdtree.generator;

import java.util.ArrayList;
import java.util.List;

import de.sciss.kdtree.KdPoint;
import de.sciss.kdtree.KdTree;

public abstract class RandomKdTreeGenerator<T extends Number & Comparable<T>> {

	public KdTree<T> generate(final int dimensionCount, final int pointCountt) {
		return new KdTree<>(dimensionCount, generatePoints(dimensionCount, pointCountt));
	}

	public KdTree<T> generate(final int dimensionCount, final List<KdPoint<T>> points) {
		return new KdTree<>(dimensionCount, points);
	}

	public List<KdPoint<T>> generatePoints(final int dimensionCount, final int pointCount) {
		final List<KdPoint<T>> points = new ArrayList<>(pointCount);

		for (int i = 0; i < pointCount; i++) {
			final List<T> position = new ArrayList<>(dimensionCount);

			for (int axisIndex = 0; axisIndex < dimensionCount; axisIndex++) {
				position.add(buildRandomValue());
			}

			points.add(new KdPoint<>(position));
		}

		return points;
	}

	public abstract T buildRandomValue();
}
